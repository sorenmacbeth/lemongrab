(ns lemongrab.core-test
  (:require [clojure.test :refer :all]
            [lemongrab.core :refer :all]
            [midje.sweet :refer :all]))

(facts "roundtrip for"
  (fact "integer"
    (deserialize (serialize 42)) => 42)
  (fact "double"
    (deserialize (serialize 3.5)) => 3.5)
  (fact "string"
    (deserialize (serialize "foo")) => "foo")
  (fact "unqualified keyword"
    (deserialize (serialize :foo)) => :foo)
  (fact "qualified keyword"
    (deserialize (serialize ::foo)) => ::foo)
  (fact "map"
    (let [payload {:foo 42 "bar" 3.5 :baz [1 "two"]}]
      (deserialize (serialize payload)) => payload))
  (fact "vector"
    (let [payload ["foo" 42 3.5 {:foo 23}]]
      (deserialize (serialize payload)) => payload)))

