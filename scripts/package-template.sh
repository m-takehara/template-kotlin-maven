#!/bin/sh
set -eu
if [ "$#" -ne 1 ]; then
    echo "Usage: $0 /absolute/path/to/kotlin_maven.zip" >&2
    exit 1
fi
case "$1" in /*) output=$1 ;; *) echo "Output path must be absolute" >&2; exit 1 ;; esac
root=$(CDPATH= cd -- "$(dirname -- "$0")/.." && pwd)
staging=$(mktemp -d)
trap 'rm -rf "$staging"' EXIT HUP INT TERM
mkdir "$staging/kotlin_maven"
cd "$root"
cp -R .gitignore pom.xml manifest.json metadata.json README.md LICENSE env specs src "$staging/kotlin_maven/"
cd "$staging"
zip -qr "$staging/template.zip" kotlin_maven
mv -f "$staging/template.zip" "$output"
