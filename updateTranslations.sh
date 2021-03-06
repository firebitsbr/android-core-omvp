if ! type "twine" > /dev/null; then
  # install foobar here
  echo "You must install Twine to continue ([sudo] gem install twine)"
  exit 1
fi

git submodule update --init --remote translations
twine generate-all-localization-files translations/strings.txt commons/src/main/res --tags android --format android

grep -rl '&amp;' commons/src/main/res | xargs sed -i "s/\&amp;/\&/g"
