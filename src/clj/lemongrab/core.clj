(ns lemongrab.core
  (:import [lemongrab Utils]
           [lemongrab.kryo ObjectInput]
           [java.io OutputStream]))

(defn #^bytes serialize
  ([object]
   (Utils/serialize object))
  ([^OutputStream output-stream object]
   (Utils/serialize output-stream object)))

(defn deserialize [^bytes b]
  (Utils/deserialize b))

(defn ^ObjectInput open-stream [input-stream]
  (Utils/openStream input-stream))

(defn read-object [^ObjectInput stream]
  (.readObject stream))
