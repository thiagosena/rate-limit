package com.thiagosena.ratelimit.api;

import com.thiagosena.ratelimit.domain.Message;
import com.thiagosena.ratelimit.domain.MessageRepository;
import com.thiagosena.ratelimit.security.SecurityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageRepository repository;
    private final SecurityService securityService;

    public MessageController(MessageRepository repository, SecurityService securityService) {
        this.repository = repository;
        this.securityService = securityService;
    }

    @GetMapping
    public Page<Message> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Message getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_CLIENT')")
    public Message newMessage(@RequestBody @Valid MessageInput messageInput) {
        return repository.save(new Message(securityService.getUser(), messageInput.content()));
    }
}
