package com.asclepius.controller;

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
@RequestMapping(value = "/api/private/user")
public class CardController {
	@Resource
	CardService cardService;

	@GetMapping("/getCards")
	public ResultDTO getCards(@RequestParam("uId") int uId) {
		ResultDTO resultDTO = new ResultDTO();
		List<CardDTO> cardDTOS = cardService.getCardsByUid(uId);
		if (cardDTOS.size() == 0) {
			resultDTO.setCode(ResponseCode.UNDETERMINED);
		} else {
			resultDTO.setData(cardDTOS);
		}
		return resultDTO;
	}

	@PostMapping("/addCard")
	public ResultDTO addCard(@RequestBody CardDTO cardDTO) {
		Card card = new Card();
		ResultDTO resultDTO = new ResultDTO();
		BeanUtils.copyProperties(cardDTO, card);
		if (cardService.addCard(card)) {
			resultDTO.setData(cardService.getCardsByUid(cardDTO.getuId()));
		} else {
			resultDTO.setCode(ResponseCode.UNPROCESSABLE_ENTITY);
		}
		return resultDTO;
	}

	@DeleteMapping("/deleteCard/{uId}/{cId}")
	public ResultDTO deleteCard(@PathVariable(name = "uId") Integer uId, @PathVariable(name = "cId") Integer cId) {
		ResultDTO resultDTO = new ResultDTO();
		if (!cardService.deleteCard(uId, cId)) {
			resultDTO.setCode(ResponseCode.NOT_FOUND);
			resultDTO.setMessage("uId或cId不合法(不提示给用户)");
		} else {
			resultDTO.setData(cardService.getCardsByUid(uId));
		}
		return resultDTO;
	}

	//@PostMapping("/alterCard")
	@Deprecated
	public ResultDTO alterCard(@RequestBody CardDTO cardDTO) {
		ResultDTO resultDTO = new ResultDTO();
		if (!cardService.alterCard(cardDTO)) {
			resultDTO.setCode(ResponseCode.NOT_FOUND);
			resultDTO.setMessage("uId或cId不合法(不提示给用户)");
		}
		return resultDTO;
	}
}
