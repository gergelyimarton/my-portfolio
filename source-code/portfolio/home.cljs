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


(defn mobile-button []
  [:img {:src "/images/more_horizontal.svg"
              :style {
                      :height "70px"
                      :width "70px"}}])


;;------------------- footer images -----------------------------

(defn github []
  [:img.contact-button {:src "/images/github.png"}])


(defn instagram []
  [:img.contact-button {:src "/images/instagram.png"}])


(defn soundcloud []
  [:img.contact-button {:src "/images/soundcloud.png"}])


(defn youtube []
  [:img.contact-button {:src "/images/youtube.png"}])


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
    [:div
     [:div.button-right
      [arrow-back]]]
    [:div.right-card-title {:class ["title-shadow"]} title]
    [:div.card
     [:div.inner-text description]]])

;;------------------- left card -----------------------------
(defn left-card [title description]
  [:div.left-card-row
   [:div.card
    [:div.inner-text description]]
   [:div.left-card-title {:class ["title-shadow"]} title]
   [:div
    [:div.button-left
     [arrow-forward]]]])

;;------------------- card container -----------------------------
(defn card-container []
  [:div.card-container
   [right-card "ABOUT ME" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [left-card "MY SKILLS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [right-card "MY GOALS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [left-card "MY HOBBIES" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
;;------------------- contacts footer -----------------------------
   [footer]])

;;------------------- mobile card -----------------------------
(defn mobile-card [title description]
  [:div.mobile-card-row                                      ;; css létrhozni
   [:div.mobile-card-title {:class ["title-shadow"]} title]  ;; css létrhozni
   [:div.mobile-card                                         ;; css létrhozni
    [:div.mobile-inner-text description]]                    ;; css létrhozni
   [:div.mobile-button                                       ;; css létrhozni
    [mobile-button]]])
                                           ;; funkciót létrhozni + ikon

;;------------------- mobile card container -----------------------------
(defn mobile-card-container []
  [:div.mobile-card-container
   [mobile-card "ABOUT ME" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [mobile-card "MY SKILLS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [mobile-card "MY GOALS" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
   [mobile-card "MY HOBBIES" "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]
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
     [mobile-card-container]
     [card-container]]])
