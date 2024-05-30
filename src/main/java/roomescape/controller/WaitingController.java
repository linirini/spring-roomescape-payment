package roomescape.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roomescape.auth.LoginMemberId;
import roomescape.service.reservation.dto.ReservationResponse;
import roomescape.service.waiting.WaitingCommonService;
import roomescape.service.waiting.WaitingCreateService;
import roomescape.service.waiting.dto.WaitingRequest;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/waitings")
public class WaitingController {

    private final WaitingCommonService waitingCommonService;
    private final WaitingCreateService waitingCreateService;

    public WaitingController(WaitingCommonService waitingCommonService, WaitingCreateService waitingCreateService) {
        this.waitingCommonService = waitingCommonService;
        this.waitingCreateService = waitingCreateService;
    }

    @PostMapping
    public ResponseEntity<ReservationResponse> createWaiting(
            @RequestBody WaitingRequest waitingRequest,
            @LoginMemberId Long memberId) {
        ReservationResponse response = waitingCreateService.createWaiting(waitingRequest, memberId);
        return ResponseEntity.created(URI.create("/waitings/" + response.id())).body(response);
    }

    @GetMapping
    public List<ReservationResponse> findAll() {
        return waitingCommonService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaiting(@PathVariable("id") long reservationId, @LoginMemberId long memberId) {
        waitingCommonService.deleteWaitingById(reservationId, memberId);
        return ResponseEntity.noContent().build();
    }
}
