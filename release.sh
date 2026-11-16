#!/bin/bash

set -x
tag="${GITHUB_REF#refs/tags/}"
gh release create "$tag" -t "Release $tag" ./*/target/*.jar
