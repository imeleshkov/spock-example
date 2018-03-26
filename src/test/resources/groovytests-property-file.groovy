HOST = 'ee.local'
PORT = 9001
SECURE_PORT = 9002

DEFAULT_HTTP_URI = "http://${HOST}:${PORT}"
DEFAULT_HTTPS_URI = "https://${HOST}:${SECURE_PORT}"

FULL_BASE_URI = DEFAULT_HTTP_URI
FULL_SECURE_BASE_URI = DEFAULT_HTTPS_URI

HTTP_WEBROOT = DEFAULT_HTTP_URI
HTTPS_WEBROOT = DEFAULT_HTTPS_URI

FAIL_ON_NAMING_CONVENTION_ERROR=false