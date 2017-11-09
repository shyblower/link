(def netty-version "4.1.17.Final")

(def example-base-command
  ["trampoline" "with-profile" "default,example" "run" "-m"])

(defproject link "0.10.3-SNAPSHOT"
  :description "A clojure framework for nonblocking network programming"
  :url "http://github.com/sunng87/link"
  :license {:name "Eclipse Public License - v 1.0"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [io.netty/netty-buffer ~netty-version]
                 [io.netty/netty-codec-http ~netty-version]
                 [io.netty/netty-codec-http2 ~netty-version]
                 [io.netty/netty-codec ~netty-version]
                 [io.netty/netty-common ~netty-version]
                 [io.netty/netty-handler ~netty-version]
                 [io.netty/netty-transport ~netty-version]
                 [org.clojure/tools.logging "0.4.0"]]
  :profiles {:dev {:dependencies [[log4j/log4j "1.2.17"]]}
             :example {:source-paths ["examples"]}}
  :scm {:name "git"
        :url "http://github.com/sunng87/link"}
  :global-vars {*warn-on-reflection* false}
  :deploy-repositories {"releases" :clojars}
  :aliases {"run-echo-example" ~(conj example-base-command "link.examples.echo")
            "run-http-simple-example" ~(conj example-base-command "link.examples.http.simple")
            "run-http-async-example"  ~(conj example-base-command "link.examples.http.async")
            "run-http-h2c-example" ~(conj example-base-command "link.examples.http.h2c")})
