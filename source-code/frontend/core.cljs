(ns frontend.core
  (:require
   [frontend.portfolio.core :as portfolio]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [reagent.session :as session]
   [reitit.frontend :as reitit]
   [clerk.core :as clerk]
   [accountant.core :as accountant]))
   


;; -------------------------

(def router
  (reitit/router
   [["/" :main]
    ["/about-me" :about-me]
    ["/my-skills" :my-skills]
    ["/my-goals" :my-goals]
    ["/my-hobbies" :my-hobbies]]))

;; Routes


(defn app []
  ;; [game/view]
  [portfolio/view])

;; -------------------------
;; Initialize app

(defn render-app! []
  (rdom/render [app] (.getElementById js/document "app")))

(defn start! []
  (clerk/initialize!)
  (accountant/configure-navigation!
   {:nav-handler (fn [path]
                   (let [match (reitit/match-by-path router path)
                         current-page (:name (:data  match))
                         route-params (:path-params match)]
                     (session/put! :route {:current-page current-page
                                           :route-params route-params})
                     (reagent/after-render clerk/after-render!)
                     (clerk/navigate-page! path)))

    :path-exists? (fn [path]
                    (boolean (reitit/match-by-path router path)))})
  (accountant/dispatch-current!)
  (render-app!))
