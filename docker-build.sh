# Build the app image
# Usage: ./docker-build.sh <app version>

export APP_VERSION=$1

docker build -t apitestbase/sample-jms-services:latest -t apitestbase/sample-jms-services:$APP_VERSION --build-arg VERSION=$APP_VERSION .