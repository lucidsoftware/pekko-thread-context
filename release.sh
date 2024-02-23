#!/bin/bash

set -x
tag="${GITHUB_REF#refs/tags/}"
targets=($(printf -- "-a %s " */target/*.jar))
hub release create "${targets[@]}" -m "Release $tag" $tag
