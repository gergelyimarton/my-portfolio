(ns portfolio.home


  (:require
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]
   [reagent.session :as session]))

;;------------------- atom functions -----------------------------
(defn change-page [new-page])
;   (reset! page new-page))

;;-----------------------------
(defn its-me []
  [:img.itsme {:src "/images/itsme.jpg"}])

;;------------------- button arrows ----------------------------
(defn arrow-back [] 
   [:img.arrow-pic-left {:src "/images/arrow_back_new.svg"}])
         ; :on-click #(change-page page)}])



(defn arrow-forward [] 
   [:img.arrow-pic-right {:src "/images/arrow_forward.svg"}])
         ; :on-click #(change-page page)}])


(defn mobile-button []
  [:img {:src "/images/more_horizontal.svg"
              :style {
                      :height "70px"
                      :width "70px"}}])
         ; :on-click #(change-page page)}])


;;------------------- footer images -----------------------------
(defn github []
  [:a.link {:href "https://github.com/gergelyimarton"}
   [:img.contact-button {:src "/images/github.png"}]])

(defn instagram []
  [:a.link {:href "https://www.instagram.com/duplajezus"}
   [:img.contact-button {:src "/images/instagram.png"}]])

(defn soundcloud []
  [:a.link {:href "https://on.soundcloud.com/t9DNR"}
   [:img.contact-button {:src "/images/soundcloud.png"}]])

(defn youtube []
  [:a.link {:href "https://www.youtube.com/channel/UC97nHE6f-2hy080NdVce3TQ/featured"}
   [:img.contact-button {:src "/images/youtube.png"}]])
;;------------------- footer -----------------------------
(defn footer []
  [:div.footer
   [github]
   [soundcloud]
   [instagram]
   [youtube]])

;;test

;;------------------- right card -----------------------------
(defn right-card [title description href]
   [:div.right-card-row
    [:div
     [:a {:href href}
      [:div.button-right 
       [arrow-back]]]]
    [:div.right-card-title {:class ["title-shadow"]} title]
    [:div.card
     [:div.inner-text description]]])

;;------------------- left card -----------------------------
(defn left-card [title description href]
  [:div.left-card-row
   [:div.card
    [:div.inner-text description]]
   [:div.left-card-title {:class ["title-shadow"]} title]
   [:div
    [:a {:href href}
      [:div.button-left
       [arrow-forward]]]]])

;;------------------- card container -----------------------------
(defn card-container []
  [:div.card-container
   [right-card "ABOUT ME"
               "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
               "/about-me"]

   [left-card "MY SKILLS"
              "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
              "/my-skills"]

   [right-card "MY GOALS"
               "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
               "/my-goals"]

   [left-card "MY HOBBIES"
              "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
              "/my-hobbies"]
;;------------------- contacts footer -----------------------------
   [footer]])

;;------------------- mobile card -----------------------------
(defn mobile-card [title description href]
  [:div.mobile-card-row
   [:div.mobile-card-title {:class ["title-shadow"]} title]
   [:div.mobile-card
    [:div.mobile-inner-text description]]
   [:a {:href href}
    [:div.mobile-button
     [mobile-button]]]])


;;------------------- mobile card container -----------------------------
(defn mobile-card-container []
  [:div.mobile-card-container
   [mobile-card "ABOUT ME"
                "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                "/about-me"]

   [mobile-card "MY SKILLS"
                "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                "/my-skills"]

   [mobile-card "MY GOALS"
                "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                "/my-goals"]

   [mobile-card "MY HOBBIES"
                "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                "/my-hobbies"]
   [footer]])

;;------------------- navbar and button -----------------------------
(defn nav-button [title href]
  [:a {:href href} title])

(defn nav-bar []
  [:div
   [nav-button "main" "/"]
   [nav-button "about-me" "/about-me"]
   [nav-button "my-skills" "/my-skills"]
   [nav-button "my-goals" "/my-goals"]
   [nav-button "my-hobbies" "/my-hobbies"]])
;;------------------- pages (main ect..) -----------------------------
(defn main-page []
  [:div.max-width-container
   [:div.title "hello friend!"]
   [:div.subtitle
    [:div "My name is Marci"]
    [:div "and this is my portfolio project!"]]
    ; [:div.itsme-container [its-me]]]
   [mobile-card-container]
   [card-container]])

(defn about-me []
  [:div.max-width-container
   [:div.subpage-container
    [:div.subpage-card-title "ABOUT ME"]
    [:div.subpage-card
     [:div.inner-text "//ABOUT ME// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
    [:div.page-button-container 
     [:a.page-arrow {:href "/"}
      [:div.page-arrow-inner-container
       [arrow-back]
       [:div.button-text-left "main"]]] 
     [:a.page-arrow {:href "/my-skills"}
      [:div.page-arrow-inner-container
       [:div.button-text-right "next"]
       [arrow-forward]]]]]]) 

(defn my-skills []
  [:div.max-width-container
   [:div.subpage-container
    [:div.subpage-card-title "MY SKILLS"]
    [:div.subpage-card
     [:div.inner-text "//MY SKILLS// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
    [:div.page-button-container
     [:a.page-arrow {:href "/about-me"}
      [:div.page-arrow-inner-container
       [arrow-back]
       [:div.button-text-left "back"]]]
     [:a.page-arrow {:href "/my-goals"}
      [:div.page-arrow-inner-container
       [:div.button-text-right "next"]
       [arrow-forward]]]]]])

(defn my-goals []
  [:div.max-width-container
   [:div.subpage-container
    [:div.subpage-card-title "MY GOALS"]
    [:div.subpage-card
     [:div.inner-text "//MY GOALS// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
    [:div.page-button-container
     [:a.page-arrow {:href "/my-skills"}
      [:div.page-arrow-inner-container
       [arrow-back]
       [:div.button-text-left "back"]]]
     [:a.page-arrow {:href "/my-hobbies"}
      [:div.page-arrow-inner-container
       [:div.button-text-right "next"]
       [arrow-forward]]]]]])

(defn my-hobbies []
  [:div.max-width-container
   [:div.subpage-container
    [:div.subpage-card-title "MY HOBBIES"]
    [:div.subpage-card
     [:div.inner-text "//MY HOBBIES// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
    [:div.page-button-container
     [:a.page-arrow {:href "/my-goals"}
      [:div.page-arrow-inner-container
       [arrow-back]
       [:div.button-text-left "back"]]]
     [:a.page-arrow {:href "/"}
      [:div.page-arrow-inner-container
       [:div.button-text-right "main"]
       [arrow-forward]]]]]])

;;/////////////// home page architecture /////////////////////////////////////////

(defn view []
  (let [page (:current-page (session/get :route))]
    [:> Parallax {:bgImage "/images/waves-1500x4000.svg"
                  :bgImageAlt "the cat"
                  :strength 1000}

     [:div [nav-bar]
      (case page
           :main [main-page]
           :about-me [about-me]
           :my-skills [my-skills]
           :my-goals [my-goals]
           :my-hobbies [my-hobbies]
           [main-page])]]))
