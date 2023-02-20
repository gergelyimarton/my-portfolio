(ns backend.html
  (:require [reagent.dom.server :as reagent-dom]
            [secretary.core :as secretary :refer-macros [defroute]]
            [config   :refer [version]]))


(enable-console-print!)


(defn with-version [url]
  (str url "?version=" version))


(defn body []
  [:div "App will load here"])

(defn template []
  [:html
   [:head
    [:title "My portfolio"]
    [:link {:type "image/png",
            :href "/images/circle-favicon.svg",
            :rel "icon"}]
    
    [:meta {:charset "utf-8"}]
    [:meta {:name    "viewport"
            :content "width=device-width, initial-scale=1.0"}]
    [:link {:type "text/css",
            :href (with-version "/css/reset.css"),
            :rel "stylesheet"}]
    [:link {:type "text/css",
            :href (with-version "/css/site.css"),
            :rel "stylesheet"}]
    [:link {:type "text/css",
            :href "https://fonts.googleapis.com/icon?family=Material+Icons",
            :rel "stylesheet"}]
    [:link {:type "text/css",
            :href "https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0",
            :rel "stylesheet"}]]
   [:body
    [:div#app [body]]

    [:script {:type "text/javascript" :src (with-version "/js/core.js")}]]])




(defn ^:export render-page [path]
  (reagent-dom/render-to-static-markup (do
                                         (secretary/dispatch! path)
                                         [template])))

