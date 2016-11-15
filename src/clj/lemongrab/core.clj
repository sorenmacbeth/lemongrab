(ns lemongrab.core
  (:import [lemongrab Utils]))

(def serialize #(Utils/serialize %))
(def deserialize #(Utils/deserialize %))
