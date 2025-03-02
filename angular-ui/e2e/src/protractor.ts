import {Config} from 'protractor';

export const config: Config = {
  // Set to true if using Jasmine framework
  framework: 'jasmine',

  // Path to the spec files (adjust the location if your spec files are organized differently)
  specs: ['./e2e/**/*.spec.ts'],

  // Browser configurations
  capabilities: {
    browserName: 'chrome',
    chromeOptions: {
      args: ['--disable-gpu', '--window-size=1920,1080'],
    },
  },

  // Configuration to use Selenium Server; set directConnect to true if you don't want to start the server manually
  directConnect: true,

  // Jasmine Node Options
  jasmineNodeOpts: {
    showColors: true, // Use colors in the command-line report
    defaultTimeoutInterval: 30000, // Timeout interval for tests
  },

  // Hooks for setup and teardown processes
  onPrepare: () => {
    // Register TypeScript for E2E tests
    require('ts-node').register({
      project: './tsconfig.json', // Use the root TypeScript configuration
    });

    // Optional: Add custom reporter if needed
    const JasmineReporter = require('jasmine-spec-reporter').SpecReporter;
    jasmine.getEnv().addReporter(
      new JasmineReporter({
        spec: {
          displayStacktrace: true,
        },
      }),
    );
  },

  // Base URL for tests if applicable
  baseUrl: 'http://localhost:4200/',

  // Disable selenium promise manager for async-await syntax
  SELENIUM_PROMISE_MANAGER: false,
};
