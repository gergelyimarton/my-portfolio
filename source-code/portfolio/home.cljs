(ns portfolio.home

  (:require 
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]
   [reagent.session :as session]
   
   ["react-scrollmagic" :refer (Controller, Scene)]
   ["react-gsap" :refer (Tween, Timeline)]
   ["gsap/dist/ScrollTrigger" :refer (ScrollTrigger)]))
  ;;  ["aos" :refer AOS]))

;;------------------- scroll magic -----------------------------

(defn tween-inner [component random-id]
  [:div {:class random-id} component])
 
(defn tween-container [component random-id x]
 [:> Tween
     {:from {:x x}   ;nem lehet csak a from-ot hasznalni mert nem toltotdik be
      :to {:x 0 
           :scrollTrigger {:trigger (str "." random-id)
                                :start "-100px center"
                                :end "180px center"
                                :scrub 1.5}}}
                           ;;  :markers "true"}}}
  [:div [tween-inner component random-id]]])
                            

(defn tween-wrapper [{:keys [component x]}]
  (let [random-id (str "tween-" (random-uuid))]
   [tween-container component random-id x]))
    
     


;;------------------- atom functions -----------------------------
(defn change-page [new-page])
;   (reset! page new-page))

;;-----------------------------
(defn scroll-down-arrow []
  [:img.scrolldownarrow {:src "/images/arrow_down.svg"}])

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
   [tween-wrapper
    {:component
      [right-card "ABOUT ME"
                    "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                    "/about-me"]
      :x "100vw"}]
   
   [tween-wrapper
    {:component
      [left-card "MY SKILLS"
                  "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                  "/my-skills"]
      :x "-100vw"}]
   
   [tween-wrapper
    {:component
      [right-card "MY GOALS"
                  "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                  "/my-goals"]
      :x "100vw"}]
   
   [tween-wrapper
    {:component
      [left-card "MY HOBBIES"
                  "Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."
                  "/my-hobbies"]
      :x "-100vw"}]
  

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
   [:div.title "Hello friend!"]
   [:div.subtitle
    [:div "My name is Marton"]
    [:div "and this is my portfolio!"]
    [:div.scrolldownarrow-container "scroll down"
     [scroll-down-arrow]]]
   [mobile-card-container]
   [card-container]])

(defn about-me []
  [:div.loading-animation-subpages
    [:div.max-width-container
     [:div.subpage-container
      [:div.subpage-card-title "ABOUT ME"]
      [:div.subpage-card
       [:div.inner-text "//ABOUT ME// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
      [:div.page-button-container 
       [:a.page-arrow {:href "/"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "MAIN"]]] 
       [:a.page-arrow {:href "/my-skills"}
        [:div.page-arrow-inner-container
         [:div.button-text-right "NEXT  "]
         [arrow-forward]]]]]]]) 

(defn my-skills []
  [:div.loading-animation-subpages
    [:div.max-width-container
     [:div.subpage-container
      [:div.subpage-card-title "MY SKILLS"]
      [:div.subpage-card
       [:div.inner-text "//MY SKILLS// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
      [:div.page-button-container
       [:a.page-arrow {:href "/about-me"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-arrow {:href "/my-goals"}
        [:div.page-arrow-inner-container
         [:div.button-text-right "NEXT"]
         [arrow-forward]]]]]]])

(defn my-goals []
  [:div.loading-animation-subpages
    [:div.max-width-container
     [:div.subpage-container
      [:div.subpage-card-title "MY GOALS"]
      [:div.subpage-card
       [:div.inner-text "//MY GOALS// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
      [:div.page-button-container
       [:a.page-arrow {:href "/my-skills"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-arrow {:href "/my-hobbies"}
        [:div.page-arrow-inner-container
         [:div.button-text-right "NEXT"]
         [arrow-forward]]]]]]])

(defn my-hobbies []
  [:div.loading-animation-subpages
    [:div.max-width-container
     [:div.subpage-container
      [:div.subpage-card-title "MY HOBBIES"]
      [:div.subpage-card
       [:div.inner-text "//MY HOBBIES// Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English."]]
      [:div.page-button-container
       [:a.page-arrow {:href "/my-goals"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-arrow {:href "/"}
        [:div.page-arrow-inner-container
         [:div.button-text-right "MAIN"]
         [arrow-forward]]]]]]])


;;------------------- pages background changer -----------------------------


(defn decide-background [page]
 (case page
         :main "/images/waves-1500x4000.svg"
               "/images/blurry.svg"))





;;/////////////// home page architecture /////////////////////////////////////////

(defn view []
  
  (let [page (:current-page (session/get :route))]
    [:div
     
     [:> Parallax {:bgImage (decide-background page)
                   :bgImageAlt "the cat"
                   :strength 1000}
      [:div
       (case page
         :main [main-page]
         :about-me [about-me]
         :my-skills [my-skills]
         :my-goals [my-goals]
         :my-hobbies [my-hobbies]
         [main-page])]]]))