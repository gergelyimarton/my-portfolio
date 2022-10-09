(ns portfolio.core
  (:require
    [portfolio.home :as home]
    [portfolio.header :as header]
    [portfolio.footer :as footer]))

;; -------------------------
;; Page components
(defn view []
  [:div.loading-animation
   [header/view]
   [home/view]
   [footer/view]])
