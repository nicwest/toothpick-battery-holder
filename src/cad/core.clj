(ns cad.core
  (:require [clojure.java.io :refer [make-parents]]
            [scad-clj.scad :refer [write-scad]]
            [scad-clj.model :refer [cube color translate rotate union difference]])
  (:gen-class))

(defn degrees [n] (* n (/ Math/PI 180)))

(def black
  [0.2 0.2 0.2])

(def silver
  [0.9 0.9 0.9])

(def green
  [0.44 0.84 0.15])

(defn render!
  [file-name part]
  (let [file-path (str "out/" file-name ".scad")]
    (make-parents file-path)
    (spit file-path
          (write-scad part))))

(def default-config {:frame-thickness 6
                     :frame-width 44
                     :battery-width 18
                     :battery-height 18
                     :battery-length 70
                     :band-clearance 0.2
                     :band-thickness 2
                     :band-width 8
                     :progger-width 6
                     :progger-thickness 6
                     :velcro-width 10
                     })

(defn config
  ([] default-config)
  ([opts]
   (merge default-config opts)))

(defn frame
  [{:keys [frame-width frame-thickness]}]
  (translate [0 0 (/ frame-thickness 2)]
             (cube frame-width frame-width frame-thickness)))


(defn battery
  [{:keys [battery-width battery-height battery-length frame-thickness]}]
  (translate [0 0 (+ (/ battery-height 2) frame-thickness)]
             (rotate (degrees 90) [0 1 0]
                     (cube battery-height battery-width battery-length))))

(defn progger
  [{:keys [progger-width band-width progger-thickness]}]
  (cube band-width progger-width  progger-thickness))


(defn progger-set
  [{:keys [band-thickness progger-width progger-thickness velcro-width]
    :as cfg}]
  (let [d (+ (/ velcro-width 2) (/ progger-width 2))
        b (- d)
        z (/ progger-thickness 2)
        z 0]
    (union
      (translate [0 b z]
                 (progger cfg))
      (translate [0 d z]
                 (progger cfg))
      )))

(defn holder
  [{:keys [battery-width battery-length band-thickness band-clearance band-width
           frame-thickness battery-height progger-thickness]
    :as cfg}]
  (let [d (/ (+ battery-width band-thickness band-clearance progger-thickness) 2)]
    (translate [0 0 (+ (/ band-width 2) (/ (- battery-height band-width) 2) frame-thickness)]
                            (rotate (degrees 90) [0 1 0]
                                      (union
                                        (difference
                                          (cube 
                                            band-width
                                            (+ battery-width band-thickness band-clearance)
                                            (+ battery-length band-thickness band-clearance)
                                            )
                                          (cube
                                            1000
                                            (+ battery-width band-clearance)
                                            (+ battery-length band-clearance)))
                                        (translate [0 d 0]
                                                   (rotate (degrees 90) [1 0 0]
                                                           (progger-set cfg)))
                                        (translate [0 (- d) 0]
                                                   (rotate (degrees 90) [1 0 0]
                                                           (progger-set cfg))
                                                   ))))
 ))

(defn thing
  [cfg]
  [
   (color black
          (frame cfg))

   (color silver
          (battery cfg))

   (color green
          (holder cfg))])

(def config-3s-550 (config {:battery-width 18
         :battery-height 18
         :battery-length 70}))

(def config-4s-850 (config {:battery-width 27.5
         :battery-height 30
         :battery-length 63}))

(render! "holder-4s-850" (holder config-4s-850))
(render! "holder-3s-550" (holder config-3s-550))
(render! "thing" (thing config-3s-550))
;(render! "thing" (progger-set (config)))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
