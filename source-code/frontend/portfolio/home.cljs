(ns frontend.portfolio.home

  (:require 
   ["react-parallax" :refer (Parallax)]
   [reagent.core :as reagent :refer [atom]]
   [reagent.session :as session]
   
   ["react-scrollmagic" :refer (Controller, Scene)]
   ["react-gsap" :refer (Tween, Timeline)]
   ["gsap/dist/ScrollTrigger" :refer (ScrollTrigger)]))
  ;;  ["aos" :refer AOS]))


(defn scroll-to-cards []
 (let [inner-height (.-innerHeight js/window)]
  (.scrollTo js/window #js {:top inner-height
                            :behavior "smooth"})
                            
       
  (.log js/console inner-height)))


;; (defn scroll-to-cards []
;;   (let [element (js/document.getElementById "scroll-here")
;;         rect (.getBoundingClientRect element)
;;         top (.-top rect)]
;;     (.log js/console top)
;;     (.scrollIntoView element)))



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
(defn home-button []
  [:img.home-button {:src "/images/home-button.svg"}])



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
                    "Hi, my name is Marton Gergelyi, and I am a 22-year-old university student. I was born in Hungary and I am fluent in Hungarian. 
                     Additionally, I have a high level of proficiency in English.
                    For several years, I have been deeply interested in information technology and creative design..."
                    "/about-me"]
      :x "100vw"}]
   
   [tween-wrapper
    {:component
      [left-card "MY SKILLS"
                  "In 2020, I embarked on my university journey in Szeged, Hungary, focusing initially on software designing before transitioning to IT engineering. 
                   Throughout my studies, I gained valuable knowledge in various areas such as network building, web development, database management, and proficiency in several programming languages..."
                  "/my-skills"]
      :x "-100vw"}]
   
   [tween-wrapper
    {:component
      [right-card "MY GOALS"
                  "My ultimate ambition is to become a Fullstack web developer, and I am dedicated to continuously learning and growing in this field. 
                   Along the way, I am eager to explore diverse areas and challenge myself to broaden my skill set. 
                   I am open to traveling within my country or even internationally to pursue opportunities that align with my aspirations..."
                  "/my-goals"]
      :x "100vw"}]
   
   [tween-wrapper
    {:component
      [left-card "MY HOBBIES"
                  "In addition to my passion for programming, I also have a deep involvement in music. For over a decade, I have been writing poems, and more recently, 
                   I have delved into writing lyrics for music. Within the past three years, I have focused on honing my skills in this area..."
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
                "Hi, my name is Marton Gergelyi, and I am a 22-year-old university student. I was born in Hungary and I am fluent in Hungarian. 
                 Additionally, I have a high level of proficiency in English.
                 For several years, I have been deeply interested in information technology and creative design..."
                "/about-me"]

   [mobile-card "MY SKILLS"
                "In 2020, I embarked on my university journey in Szeged, Hungary, focusing initially on software designing before transitioning to IT engineering. 
                         Throughout my studies, I gained valuable knowledge in various areas such as network building, web development, database management, and proficiency in several programming languages..."
                "/my-skills"]

   [mobile-card "MY GOALS"
                "My ultimate ambition is to become a Fullstack web developer, and I am dedicated to continuously learning and growing in this field. 
                   Along the way, I am eager to explore diverse areas and challenge myself to broaden my skill set. 
                   I am open to traveling within my country or even internationally to pursue opportunities that align with my aspirations..."
                "/my-goals"]

   [mobile-card "MY HOBBIES"
                "In addition to my passion for programming, I also have a deep involvement in music. For over a decade, I have been writing poems, and more recently, 
                   I have delved into writing lyrics for music. Within the past three years, I have focused on honing my skills in this area..."
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
    [:div.scrolldownarrow-container {:on-click (fn [e] (scroll-to-cards))}
     "scroll down"
     [scroll-down-arrow]]]
   [mobile-card-container]
   [card-container]])

(defn about-me []
  [:div.loading-animation-subpages
    [:div.max-width-container
     [:div.subpage-container
      [:div.subpage-card-title "ABOUT ME"]
      [:div.subpage-card
       [:div.inner-text
        [:div.text-separator "Hi, my name is Marton Gergelyi, and I am a 22-year-old university student. I was born in Hungary and I am fluent in Hungarian. Additionally, I have a high level of proficiency in English."]
        [:div.text-separator "For several years, I have been deeply interested in information technology and creative design. I have explored my creativity in various fields, but I have found a strong passion and potential career path in web development and IT security."]
        [:div.text-separator "Programming has become a significant milestone in my journey. I firmly believe that in the near future, it will be essential for the majority of people to have at least a basic understanding of programming languages."]
        [:div "As an individual, I am diligent, adaptable, and a quick learner. I am comfortable working both collaboratively as part of a team and independently. I always strive to consistently deliver excellent results."]]]
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
       [:div.inner-text
        [:div.text-separator "In 2020, I embarked on my university journey in Szeged, Hungary, focusing initially on software designing before transitioning to IT engineering. 
               Throughout my studies, I gained valuable knowledge in various areas such as network building, web development, database management, and proficiency in several programming languages. 
               I honed these skills both independently and as part of a team, working with languages such as Python, Scala, JavaScript, C/C++, HTML, and CSS."]
        [:div.text-separator "Alongside programming, I have developed a solid foundation in utilizing tools like git and terminal, as well as employing Kanban and agile development methodologies. 
               Currently, I am further enhancing my expertise by training in Clojure and ClojureScript, while also expanding my knowledge in web design."]
        [:div "In September 2022, I relocated to Ireland to enhance my language skills on an international level and seek out IT courses that align with my interests. 
               This move has allowed me to supplement my education and explore opportunities beyond what I have learned in school."]]]
      [:div.page-button-container
       [:a.page-arrow {:href "/about-me"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-home-button {:href "/"}
        [:div.page-home-button-inner-container
         [home-button]]]
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
       [:div.inner-text
        [:div.text-separator "My ultimate ambition is to become a Fullstack web developer, and I am dedicated to continuously learning and growing in this field. 
               Along the way, I am eager to explore diverse areas and challenge myself to broaden my skill set. 
               I am open to traveling within my country or even internationally to pursue opportunities that align with my aspirations."]
        [:div.text-separator "Finding a cooperative, understanding, and friendly team to collaborate with is paramount to me. 
               While I am not averse to working in a large corporate environment, I am equally enthusiastic about contributing to smaller companies. 
               I find immense satisfaction in creative work, both within the realm of programming and in my personal life."]
        [:div.text-separator "Moreover, my interest in IT security is profound, and I remain open to the possibility of pursuing a career as an ethical hacker. 
               This avenue offers an exciting prospect for me to utilize my skills and contribute to maintaining digital security."]
        [:div "Overall, my goal is to continuously learn, develop, and embrace various professional avenues that align with my passions and potential."]]]
      [:div.page-button-container
       [:a.page-arrow {:href "/my-skills"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-home-button {:href "/"}
        [:div.page-home-button-inner-container
         [home-button]]]
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
       [:div.inner-text
        [:div.text-separator "In addition to my passion for programming, I also have a deep involvement in music. For over a decade, I have been writing poems, and more recently, 
               I have delved into writing lyrics for music. Within the past three years, I have focused on honing my skills in this area."]
        [:div.text-separator "In 2019, I had the opportunity to showcase my musical talents as a bass guitarist and singer in a band. 
               Following that experience, I embarked on an independent career as a hip-hop artist. 
               I began exploring the art of music mixing in 2022, utilizing music composition software such as Ableton to enhance my sound. 
               While hip-hop holds a special place in my heart, I find myself captivated by the intricate and energetic world of Drum and Bass. 
               This genre presents me with the opportunity to continuously explore and present fresh and unique sounds."]
        [:div "Currently, I operate under two names, which can be found on platforms such as SoundCloud and YouTube. 
               These channels serve as outlets for sharing my musical creations with the world."]]]
      [:div.page-button-container
       [:a.page-arrow {:href "/my-goals"}
        [:div.page-arrow-inner-container
         [arrow-back]
         [:div.button-text-left "BACK"]]]
       [:a.page-arrow {:href "/"}
        [:div.page-arrow-inner-container
         [:div.button-text-right "MAIN"]
         [arrow-forward]]]]]]])

;;------------------- theme checker -----------------------------

(def dark-theme? (.-matches (.matchMedia js/window "(prefers-color-scheme: dark)")))

;;------------------- pages background changer -----------------------------

(defn decide-background [page]
 (case page
         :main (if dark-theme? "/images/layered-1500x4000.svg" "/images/waves-1500x4000.svg")
               (if dark-theme? "/images/blurry-dark.svg" "/images/blurry.svg")))


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