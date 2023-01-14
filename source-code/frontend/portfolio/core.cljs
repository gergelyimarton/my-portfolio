(ns frontend.portfolio.core
  (:require
    [frontend.portfolio.home :as home]
    [frontend.portfolio.header :as header]
    [frontend.portfolio.footer :as footer]))

;; -------------------------
;; Page components
(defn view []
  [:div.loading-animation
   [header/view]
   [home/view]
   [footer/view]])
