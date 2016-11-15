![Lemongrab](doc/lemongrab.gif)

# lemongrab

Kryo for Clojure

## Usage

``` clojure
user> (require '[lemongrab.core :refer [serialize deserialize]])
nil
user>(deserialize (serialize [1 2 3 4 5]))
[1 2 3 4 5]
user>(deserialize (serialize #{1 2 3 4}))
#{1 4 3 2}
```

## License

Copyright © 2016 Yieldbot, Inc. 

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
