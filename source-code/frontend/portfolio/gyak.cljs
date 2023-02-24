;; (ns frontend.portfolio.gyak)

(def szo-lista ["perec" "talaj" "parafa" "facan" "bolond"])

(def szazas-lisa (range 100))

(def tizes-lista [0 1 2 3 4 5 6 7 8 9])

(def huszas-lista [10 11 12 13 14 15 16 17 18 19])

(def terkep-egy {:elso 1 :masodik 2 :harmadik 3 :negyedik 4})

(def terkep-ketto {:1 "alma" :2 "cica" :3 "motor" :4 "haz"})

(def negativ-szamok (mapv (fn [number] (- number 10) ) tizes-lista))

(def atomos (atom 300))

(def pozitiv-es-negativ (concat szazas-lisa negativ-szamok))

(defn minusz-tiz [number]
  (- number 10))

(map inc tizes-lista)
(map dec huszas-lista)
(map + tizes-lista huszas-lista)
(mapv + tizes-lista huszas-lista)
(filter even? szazas-lisa)
(filter odd? szazas-lisa)
(mapv + huszas-lista negativ-szamok)
(concat huszas-lista negativ-szamok)
(conj huszas-lista negativ-szamok)
(remove neg? (concat huszas-lista negativ-szamok))
(assoc terkep-ketto :elso 1 :masodik 2 :harmadik 3 :negyedik 4)
(merge terkep-egy terkep-ketto)
(dissoc terkep-egy :harmadik)
(drop 70 szazas-lisa)
(drop-last 5 tizes-lista)
(doseq [x [1 2 3]
        y [4 5 6]
        z [7 8 9]
        t [11 22 33]]
    (println x "-" y)
    (println y "-" z)
    (println z "-" x)
    (println t "-" x)
    (println t "-" y)
    (println t "-" z))
(assoc-in {} szo-lista "paul eleg pacek")
(reset! atomos {})
(swap! atomos (fn [e] (str "a" e)))
        
 








;; (map (fn [] (partition 2 (range 4))))





    ;; map
;; "Returns a lazy sequence consisting of the result of applying f to
;; the set of first items of each coll, followed by applying f to the
;; set of second items in each coll, until any one of the colls is
;; exhausted."

;; (map inc [1 2 3 4 5])
;;=> (2 3 4 5 6)

;; (map + [1 2 3] [4 5 6])
;;=> (5 7 9)





;;  mapv
;; "Returns a vector consisting of the result of applying f to the
;; set of first items of each coll, followed by applying f to the set
;; of second items in each coll, until any one of the colls is
;; exhausted."
;; (mapv inc [1 2 3 4 5])
;;=> [2 3 4 5 6]

;; (mapv + [1 2 3] [4 5 6])
;;=> [5 7 9]





;;  filter
;; "Returns a lazy sequence of the items in coll for which
;; (pred item) returns logical true."

;; (filter even? (range 10))
;;=> (0 2 4 6 8)

;; (filter #(> (second %) 100)
;;         {:a 1
;;          :b 2
;;          :c 101
;;          :d 102
;;          :e -1})
;;=> ([:c 101] [:d 102])




;;  remove
;; "Returns a lazy sequence of the items in coll for which
;; (pred item) returns logical false."

;; (remove pos? [1 -2 2 -1 3 7 0])
;;=> (-2 -1 0)

;; (remove nil? [1 nil 2 nil 3 nil])
;;=> (1 2 3)


    

;;  assoc
;; "When applied to a map, returns a new map of the
;; same (hashed/sorted) type, that contains the mapping of key(s) to
;; val(s). When applied to a vector, returns a new vector that
;; contains val at index."
    

;; (assoc {} :key1 "value" :key2 "another value")
;;=> {:key2 "another value", :key1 "value"}

;; (assoc {:key1 "old value1" :key2 "value2"}
     ;; :key1 "value1" :key3 "value3")
;;=> {:key3 "value3", :key2 "value2", :key1 "value1"}
    



;;  dissoc
;; "Returns a new map of the same (hashed/sorted) type,
;; that does not contain a mapping for key(s)."


;; (dissoc {:a 1 :b 2 :c 3}) ; dissoc nothing 
;;=> {:a 1, :b 2, :c 3} 

;; (dissoc {:a 1 :b 2 :c 3} :b) ; dissoc key :b
;;=> {:a 1, :c 3} 

;; (dissoc {:a 1 :b 2 :c 3} :d) ; dissoc not existing key
;;=> {:a 1, :b 2, :c 3} 

;; (dissoc {:a 1 :b 2 :c 3} :c :b); several keys at once
;;=> {:a 1} 



;;  conj
;; "Returns a new collection."

;; (conj [1 2 3] 4)
;;=> [1 2 3 4]

;; (conj '(1 2 3) 4)
;;=> (4 1 2 3)

;; (conj ["a" "b" "c"] "d")
;;=> ["a" "b" "c" "d"]


;;  concat
;; "Returns a lazy seq representing 
;; the concatenation of the elements in the supplied colls."
    
;; (concat [1 2] [3 4])
;; => (1 2 3 4)

;; (into [] (concat [1 2] [3 4]))
;; => [1 2 3 4]





;;    drop
;; "Returns a lazy sequence of all but the first n items in coll.
;;  Returns a stateful transducer when no collection is provided."
;; although negative (or zero) drop-item-counts are accepted they do nothing
;; (drop -1 [1 2 3 4])
;;=> (1 2 3 4) 

;; (drop 0 [1 2 3 4])
;;=> (1 2 3 4) 

;; (drop 2 [1 2 3 4])
;;=> (3 4) 

;; dropping more items than are present is allowed, and all items are dropped.
;; (drop 5 [1 2 3 4]
;;=> ()




;;    drop-last

;; "Return a lazy sequence of all but the last n (default 1) items in coll"
;; (drop-last [1 2 3 4])
; => (1 2 3) 

;; (drop-last -1 [1 2 3 4])
; => (1 2 3 4) 

;; (drop-last 0 [1 2 3 4])
; => (1 2 3 4) 

;; (drop-last 5 [1 2 3 4])
; => ()



;;  doseq
;; "Repeatedly executes body (presumably for side-effects) with
;; bindings and filtering as provided by "for" .  Does not retain
;; the head of the sequence. Returns nil."
      
;; (doseq [x [-1 0 1]
;;         y [1  2 3]]
;;   (prn (* x y)))
;; -1 ; x -1 y 1
;; -2 ; x -1 y 2
;; -3 ; x -1 y 3
;; 0  ; x 0  y 1
;; 0  ; x 0  y 2
;; 0  ; x 0  y 3
;; 1  ; x 1  y 1
;; 2  ; x 1  y 2
;; 3  ; x 1  y 3
;; nil






;;  vec
;; "Creates a new vector containing the contents of coll. Java arrays 
;;  will be aliased and should not be modified."
    
;; (vec '(1 2 3))
;; => [1 2 3]

;; (vec [1 2 3])
;; => [1 2 3]

;; (vec #{1 2 3})
;; => [1 2 3]

;; (vec {:a 1 :b 2 :c 3})
;; => [[:a 1] [:b 2] [:c 3]]

;; (vector {:a 1 :b 2 :c 3})
;; => [{:a 1, :b 2, :c 3}]





    ;; vector
;; "Creates a new vector containing the args."

;; create an empty vector the long way
;; (vector)
;; => []

;; create an empty vector the short way
;; []
;; => []

;; you can even create vectors with nil values
;; (vector nil)
;; => [nil]

;; create a vector the long way
;; (vector 1 2 3)
;; => [1 2 3]






    ;;  reset!
;; "Sets the value of atom to newval without regard for the
;; current value. Returns newval."

;; (def x (atom 10))
;; => #'user/x

;; @x
;; => 10

;; (reset! x 20)
;; => 20

;; @x
;; => 20




    ;;  swap!
;; "Atomically swaps the value of atom to be:
;; (apply f current-value-of-atom args). Note that f may be called
;; multiple times, and thus should be free of side effects.  Returns
;; the value that was swapped in."
        
;; make an atomic list
;; (def players (atom ()))
;; #'user/players

;; conjoin a keyword into that list
;; (swap! players conj :player1)
;;=> (:player1)

;; conjoin a second keyword into the list
;; (swap! players conj :player2)
;;=> (:player2 :player1)

;; take a look at what is in the list
;; (deref players)
;;=> (:player2 :player1)




