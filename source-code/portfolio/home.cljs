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

;;------------------- footer -----------------------------
(defn footer []
  [:div.footer
   [github]
   [instagram]
   [soundcloud]
   [youtube]])
;;------------------- right card -----------------------------
(defn right-card [title description]
   [:div.right-card-row
    [:div.button-right
     [arrow-back]]
    [:div.about-me {:class ["title-shadow"]} title]
    [:div.card
     [:div.inner-text description]]])

;;------------------- left card -----------------------------
(defn left-card [title description]
  [:div.left-card-row
   [:div.card
    [:div.inner-text description]]
   [:div.my-skills {:class ["title-shadow"]} title]
   [:div.button-left
    [arrow-forward]]])

;;------------------- mobile card container -----------------------------
(defn mobile-card-container []
  [:div])


;;------------------- card container -----------------------------
(defn card-container []
  [:div.card-container
   [right-card "ABOUT ME" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [left-card "MY SKILLS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [right-card "MY GOALS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [left-card "MY HOBBIES" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]

   ;;------------------- contacts footer -----------------------------
   [footer]])



;;/////////////// home page architecture /////////////////////////////////////////

(defn view []
  [:> Parallax {:bgImage "/images/clouds.jpg"
                :bgImageAlt "the cat"
                :strength 1500}


;;------------------- title properties -----------------------------
    [:div.max-width-container
     [:div.title "hello friend!"]
     [:div.subtitle
      [:div "My name is Marci"]
      [:div "and this is my portfolio project!"]]
     [card-container]]])
