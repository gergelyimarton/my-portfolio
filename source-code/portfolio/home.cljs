(ns portfolio.home
  (:require
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]))


(defn arrow-back []
  [:img {:src "/images/arrow_back.svg"
              :style {
                      :padding-left "20px"
                      :height "70px"
                      :width "70px"}}])











;;/////////////// home page architecture /////////////////////////////////////////

(defn view []
  [:> Parallax {:bgImage "/images/clouds.jpg"
                :bgImageAlt "the cat"
                :strength 1100}

    [:div.max-width-container
     [:div.title "hello friend!"]
     [:div.subtitle
      [:div "My name is Marci"]
      [:div "and this is my portfolio project!"]]
     [:div.card-container {:style {:height "1000px"
                                   :padding-top "500px"}}
      [:div.right-card-row
       [:div.button-right
        [arrow-back]]
       [:div.about-me "About me"]
       [:div.card
        [:div.inner-text "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]]]]])
