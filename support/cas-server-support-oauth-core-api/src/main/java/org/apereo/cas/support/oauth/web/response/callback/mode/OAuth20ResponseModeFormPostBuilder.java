package org.apereo.cas.support.oauth.web.response.callback.mode;

import org.apereo.cas.services.RegisteredService;
import org.apereo.cas.support.oauth.web.response.callback.OAuth20ResponseModeBuilder;
import org.apereo.cas.web.flow.CasWebflowConstants;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is {@link OAuth20ResponseModeFormPostBuilder}.
 *
 * @author Misagh Moayyed
 * @since 7.0.0
 */
@Slf4j
public class OAuth20ResponseModeFormPostBuilder implements OAuth20ResponseModeBuilder {
    @Override
    public ModelAndView build(final RegisteredService registeredService,
                              final String redirectUrl, final Map<String, String> parameters) throws Exception {
        val model = new LinkedHashMap<String, Object>();
        model.put("originalUrl", redirectUrl);
        model.put("parameters", parameters);
        val mv = new ModelAndView(CasWebflowConstants.VIEW_ID_POST_RESPONSE, model);
        LOGGER.debug("Redirecting to [{}] with model [{}]", mv.getViewName(), mv.getModel());
        return mv;
    }
}
