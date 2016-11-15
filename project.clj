(defproject yieldbot/lemongrab "0.1.0-SNAPSHOT"
  :description "Kryo for Clojure"
  :url "https://github.com/yieldbot/lemongrab"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.twitter/carbonite "1.5.0"]
                 [com.esotericsoftware/kryo "3.0.3"]
                 [com.twitter/chill-java "0.8.0"]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/jvm"])
