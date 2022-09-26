(ns index.core
  (:require
   [reitit.ring :as reitit-ring]
   [hiccup.page :refer [include-js include-css html5]]
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]))

(def middleware
  [#(wrap-defaults % site-defaults)])

(def mount-target
  [:div#app])

(defn head []
  [:head
   [:title "hello"]
   [:meta {:charset "utf-8"}]
   [:meta {:name "viewport" 
           :content "width=device-width, initial-scale=1"}]
   [:link {:rel "icon"
           :type "image/png"
           :href "/images/favicon.png"}]
   (include-css "/css/site.css")
   (include-css "https://fonts.googleapis.com/icon?family=Material+Icons")
   (include-css "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0")])

(defn loading-page []
  (html5
   (head)
   [:body {:class "body-container"}
    mount-target
    (include-js "https://murdad.github.io/ffontsloader/dist/fontsloader.js")
    (include-js "/external-js/detect-provider.min.js")
    (include-js "/external-js/web3.min.js")
    (include-js "/js/core/app.js")]))



(defn index-handler
  [_request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (loading-page)})

(def app
  (reitit-ring/ring-handler
   (reitit-ring/router
    [["/" {:get {:handler index-handler}}]
     ["/items"
      ["" {:get {:handler index-handler}}]
      ["/:item-id" {:get {:handler index-handler
                          :parameters {:path {:item-id int?}}}}]]
     ["/about" {:get {:handler index-handler}}]])
   (reitit-ring/routes
    (reitit-ring/create-resource-handler {:path "/" :root "/public"})
    (reitit-ring/create-default-handler))
   {:middleware middleware}))
