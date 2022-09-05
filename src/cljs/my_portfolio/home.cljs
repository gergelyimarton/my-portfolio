(ns my-portfolio.home
  (:require
   [reagent.core :as reagent :refer [atom]]))




;;/////////////// home page architect /////////////////////////////////////////


(defn view []
  [:div.base
   [:div.home "hello world"]])
