package org.apereo.cas;

import org.apereo.cas.webauthn.web.flow.WebAuthnStartRegistrationActionTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

/**
 * This is {@link AllWebAuthnTestsSuite}.
 *
 * @author Misagh Moayyed
 * @since 6.0.0-RC3
 */
@SelectClasses({
    WebAuthnStartRegistrationActionTests.class
})
@RunWith(JUnitPlatform.class)
public class AllWebAuthnTestsSuite {
}
