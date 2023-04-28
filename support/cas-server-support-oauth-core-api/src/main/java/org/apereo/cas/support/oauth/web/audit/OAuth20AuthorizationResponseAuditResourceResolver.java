package org.apereo.cas.support.oauth.web.audit;

import org.apereo.cas.configuration.model.core.audit.AuditEngineProperties;
import org.apereo.cas.util.DigestUtils;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.apereo.inspektr.audit.spi.support.ReturnValueAsStringResourceResolver;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * The {@link OAuth20AuthorizationResponseAuditResourceResolver} for audit advice.
 *
 * @author Misagh Moayyed
 * @since 6.0.0
 */
@RequiredArgsConstructor
public class OAuth20AuthorizationResponseAuditResourceResolver extends ReturnValueAsStringResourceResolver {
    private final AuditEngineProperties properties;

    @Override
    public String[] resolveFrom(final JoinPoint auditableTarget, final Object retval) {
        val model = (ModelAndView) retval;
        val values = new HashMap<>();
        model.getModel().forEach((key, value) ->
            values.put(key, DigestUtils.abbreviate(value.toString(), properties.getAbbreviationLength())));
        return new String[]{auditFormat.serialize(values)};
    }
}
