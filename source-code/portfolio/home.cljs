(ns portfolio.home
  (:require
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]))

(defn view []
  [:> Parallax {:bgImage "/images/clouds.jpg"
                :bgImageAlt "the cat"
                :strength 1000}

    [:div.max-width-container
     [:div.title "hello friend!"]
     [:div.subtitle
      [:div "My name is Marci"]
      [:div "and this is my portfolio project!"]]
     [:div.card-container {:style {:height "1000px"
                                   :padding-top "500px"}}
      [:div.right-card
       [:div.button-right "button"]
       [:div.about-me "About me"]
       [:div.about-me-text
        [:div.inner-text "text"]]]]]])
