(defproject brew-install-specific "0.1.0"
  :description "Install specific versions of brew packages."
  :url "https://github.com/divs1210/brew-install-specific"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clansi "1.0.0"]
                 [clj-jgit "1.0.0-beta3"]]
  :main ^:skip-aot brew-install-specific.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-shell "0.5.0"]]}}
  :aliases
  {"native"
   ["shell"
    "native-image"
    "--no-fallback"
    "--report-unsupported-elements-at-runtime"
    "--initialize-at-build-time"
    "-jar" "./target/uberjar/${:uberjar-name:-${:name}-${:version}-standalone.jar}"
    "-H:Name=./target/${:name}"]})
