(ns cad.core
  (:require [clojure.java.io :refer [make-parents]]
            [scad-clj.scad :refer [write-scad]]
            [scad-clj.model :refer [cube]])
  (:gen-class))

(defn degrees [n] (* n (/ Math/PI 180)))

(defn render!
  [file-name part]
  (let [file-path (str "out/" file-name ".scad")]
    (make-parents file-path)
    (spit file-path
          (write-scad part))))

(defn config
  ([] (config {}))
  ([opts]
  (let [opts (merge {:pretty? false }
                    opts)]

    opts)))

(def thing
  (cube 10 10))

(render! "thing" thing)


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
