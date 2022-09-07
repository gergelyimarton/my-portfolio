(ns my-portfolio.home
  (:require
    ["react-parallax" :refer [Parallax]]
    [reagent.core :as reagent :refer [atom]]))



(defn parallax []
  (reagent/create-class {:component-did-mount (fn [this] (let [scene (.getElementById js/document "parallax")]
                                                           (js/Parallax. scene)))
                         :reagent-render (fn []
                                           [:div#parallax
                                            [:div.background {:data-depth 0.4}]
                                            [:div {:data-depth 0} "Szöveg"]])}))


;;/////////////// home page structure /////////////////////////////////////////


(defn view []
  [:div.base
   

   [:div.home
    [:div.title "hello friend!"]
    [:div.subtitle
     [:div "My name is Marci"]
     [:div "and this is my portfolio project!"]]
    [:div {:style {:height "10000px"}}]]])
