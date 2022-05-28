package com.bank.kata.config;

import org.springframework.data.domain.AuditorAware;


import java.util.Optional;

public class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
       return Optional.empty();
    }

}
