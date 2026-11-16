#!/bin/bash

set -ex
tag="${GITHUB_REF#refs/tags/}"
gh release create "$tag" -t "Release $tag" ./artifacts/scala-*/pekko-actor-thread-context/*.jar
