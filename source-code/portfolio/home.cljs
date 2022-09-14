(ns portfolio.home
  (:require
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]))



;;------------------- button arrows -----------------------------
(defn arrow-back []
  [:img {:src "/images/arrow_back.svg"
              :style {
                      :padding-left "25px"
                      :height "70px"
                      :width "70px"}}])

(defn arrow-forward []
  [:img {:src "/images/arrow_forward.svg"
              :style {
                      :padding-left "10px"
                      :height "70px"
                      :width "70px"}}])

;;------------------- footer images -----------------------------

(defn github []
  [:img.contact-button {:src "/images/github.png"
                             :style {
                                     :height "100px"
                                     :width "100px"}}])

(defn instagram []
  [:img.contact-button {:src "/images/instagram.png"
                             :style {
                                     :height "100px"
                                     :width "100px"}}])

(defn soundcloud []
  [:img.contact-button {:src "/images/soundcloud.png"
                             :style {
                                     :height "115px"
                                     :width "115px"}}])

(defn youtube []
  [:img.contact-button {:src "/images/youtube.png"
                             :style {
                                     :height "110px"
                                     :width "110px"}}])


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
     [:div.card-container
;;------------------- about me -----------------------------
      [:div.right-card-row
       [:div.button-right
        [arrow-back]]
       [:div.about-me "ABOUT ME"]
       [:div.card
        [:div.inner-text "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]]
;;------------------- my skills -----------------------------
      [:div.left-card-row
       [:div.card
        [:div.inner-text "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
       [:div.my-skills "MY SKILLS"]
       [:div.button-left
        [arrow-forward]]]
;;------------------- my goals -----------------------------
      [:div.right-card-row
       [:div.button-right
        [arrow-back]]
       [:div.my-goals "MY GOALS"]
       [:div.card
        [:div.inner-text "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]]
;;------------------- my hobbys -----------------------------
      [:div.left-card-row
       [:div.card
        [:div.inner-text "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
       [:div.my-hobbys "MY HOBBYS"]
       [:div.button-left
        [arrow-forward]]]
;;------------------- contacts footer -----------------------------
      [:div.footer
       [github]
       [instagram]
       [soundcloud]
       [youtube]]]]])
