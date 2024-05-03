#!/bin/sh

echo "Running Gherkin Lint"
npx gherkin-lint -c .gherkin-lintrc ./src
echo "Gherkin Lint Complete"

exit
