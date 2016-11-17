(ns lemongrab.core
  (:import [lemongrab Utils]))

(defn serialize
  ([object]
   (Utils/serialize object))
  ([output-stream object]
   (Utils/serialize output-stream object)))

(def deserialize #(Utils/deserialize %))

(defn open-stream [input-stream]
  (Utils/openStream input-stream))

