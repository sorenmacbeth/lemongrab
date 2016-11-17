![Lemongrab](doc/lemongrab.gif)

# lemongrab

Kryo for Clojure

## Usage

``` clojure
user> (require '[lemongrab.core :as lemongrab])
nil
```

### Serialize to and deserialize from byte arrays

``` clojure
user> (lemongrab/deserialize (serialize [1 2 3 4 5]))
[1 2 3 4 5]
user> (lemongrab/deserialize (serialize #{1 2 3 4}))
#{1 4 3 2}
user> (type (lemongrab/serialize :foo))
[B
```

### Serialize to an OutputStream

``` clojure
user> (with-open [out (clojure.java.io/output-stream "/tmp/foo")]
        (lemongrab/serialize out :foo)
        (lemongrab/serialize out :bar))
nil
```

### Deserialize from an InputStream

``` clojure
user> (with-open [oi (lemongrab/open-stream (clojure.java.io/input-stream "/tmp/foo"))]
        [(lemongrab/read-object oi)
         (lemongrab/read-object oi)])
[:foo :bar]
```

## License

Copyright © 2016 Yieldbot, Inc. 

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
