(ns portfolio.core
  (:require
    [portfolio.home :as home]
    [portfolio.header :as header]
    [portfolio.footer :as footer]))

;; -------------------------
;; Page components
(defn example []
  [:div.example-card {:style {:height "100px"
                              :width "100vw"
                              :position "fixed"
                              :top "0"
                              :z-index "1000"}}])




(defn view []
  [:div.loading-animation
   [example]
   [header/view]
   [home/view]
   [footer/view]])
