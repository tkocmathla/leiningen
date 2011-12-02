(ns leiningen.test.helper
  (:require [leiningen.core.project :as project]
            [clojure.java.io :as io]))

;; TODO: fix
(def local-repo (io/file (System/getProperty "user.home") ".m2" "repository"))

(defn m2-dir [n v]
  (io/file local-repo
           (if (string? n) n (or (namespace n) (name n))) (name n) v))

(defn- read-test-project [name]
  (binding [*ns* (find-ns 'leiningen.core)]
    (project/read (format "test_projects/%s/project.clj" name))))

(def sample-project (read-test-project "sample"))

(def dev-deps-project (read-test-project "dev-deps-only"))

(def sample-failing-project (read-test-project "sample_failing"))

(def sample-no-aot-project (read-test-project "sample_no_aot"))

(def tricky-name-project (read-test-project "tricky-name"))

(def native-project (read-test-project "native"))
