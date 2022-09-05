(ns my-portfolio.prod
  (:require [my-portfolio.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
