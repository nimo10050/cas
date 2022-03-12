const puppeteer = require('puppeteer');
const path = require('path');
const cas = require('../../cas.js');

(async () => {
    const browser = await puppeteer.launch(cas.browserOptions());
    try {
        const page = await cas.newPage(browser);
        await page.goto("http://localhost:9443/simplesaml/module.php/core/authenticate.php?as=default-sp", {waitUntil: 'networkidle2'});
        await page.waitForTimeout(2000)
        await cas.screenshot(page);
        await cas.loginWith(page, "casuser", "Mellon");

        await page.waitForSelector('#table_with_attributes', {visible: true});
        await cas.assertInnerTextContains(page, "#content p", "status page of SimpleSAMLphp");
        await cas.assertVisibility(page, "#table_with_attributes");

        let authData = JSON.parse(await cas.innerHTML(page, "details pre"));
        console.log(authData);

    } finally {
        await cas.removeDirectory(path.join(__dirname, '/saml-md'));
    }
    await browser.close();
})();
