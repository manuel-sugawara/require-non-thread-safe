(ns require-issue.core
  (:require [cheshire.core :as json])
  (:gen-class))


(println "Requiring require-issue.core")

(defn json-read-string
  [src]
  (json/parse-string src))

(defn json-to-string
  [src]
  (json/generate-string src))
