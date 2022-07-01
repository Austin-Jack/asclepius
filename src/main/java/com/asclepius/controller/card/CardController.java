package com.asclepius.controller.card;

import com.asclepius.common.ResponseCode;
import com.asclepius.dto.CardDTO;
import com.asclepius.dto.ResultDTO;
import com.asclepius.pojo.Card;
import com.asclepius.service.CardService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/private")
public class CardController {

    @Resource
    CardService cardService;

    @GetMapping("/user/getCards")
    public ResultDTO getCards(int uid) {
        ResultDTO resultDTO = new ResultDTO();
        List<CardDTO> cardDTOS = cardService.getCardsByUid(uid);
        if (cardDTOS.size() == 0) {
            resultDTO.setCode(ResponseCode.UNDETERMINED);
        } else {
            resultDTO.setData(cardDTOS);
        }
        return resultDTO;
    }

    @PostMapping("/user/addCard")
    public ResultDTO addCard(@RequestBody CardDTO cardDTO) {
        Card card = new Card();
        ResultDTO resultDTO = new ResultDTO();
        BeanUtils.copyProperties(cardDTO, card);
        if (!cardService.addCard(card)) {
            resultDTO.setCode(ResponseCode.INTERNAL_SERVER_ERROR);
        }
        return resultDTO;
    }

    @DeleteMapping("/user/deleteCard/{uId}/{cId}")
    public ResultDTO deleteCard(@PathVariable(name = "uId") Integer uId, @PathVariable(name = "cId") Integer cId) {
        ResultDTO resultDTO = new ResultDTO();
        if (!cardService.deleteCard(uId, cId)) {
            resultDTO.setCode(ResponseCode.NOT_FOUND);
            resultDTO.setMessage("uId或cId不合法(不提示给用户)");
        }
        return resultDTO;
    }

    @PostMapping("/user/alterCard")
    public ResultDTO alterCard(@RequestBody CardDTO cardDTO) {
        ResultDTO resultDTO = new ResultDTO();
        if (!cardService.alterCard(cardDTO)) {
            resultDTO.setCode(ResponseCode.NOT_FOUND);
            resultDTO.setMessage("uId或cId不合法(不提示给用户)");
        }
        return resultDTO;
    }


}
