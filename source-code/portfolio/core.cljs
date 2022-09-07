(ns portfolio.core
  (:require
    [portfolio.home :as home]
    [portfolio.header :as header]
    [portfolio.footer :as footer]))

;; -------------------------
;; Page components

(defn view []
  [:div
     [header/view]
     [home/view]
     [footer/view]])
