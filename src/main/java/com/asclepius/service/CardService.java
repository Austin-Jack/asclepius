package com.asclepius.service;

import com.asclepius.dto.CardDTO;
import com.asclepius.mapper.CardMapper;
import com.asclepius.mapper.UserMapper;
import com.asclepius.pojo.Card;
import com.asclepius.pojo.CardExample;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: sny
 * @CreateTime: 2022-06-30  15:38
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class CardService {
	@Resource
	CardMapper cardMapper;


	public List<CardDTO> getCardsByUid(int uid) {
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUIdEqualTo(uid).andCStatusEqualTo(1);
		List<Card> cards = cardMapper.selectByExample(cardExample);
		return cards.stream().map(card -> {
			CardDTO cardDTO = new CardDTO();
			BeanUtils.copyProperties(card, cardDTO);
			return cardDTO;
		}).collect(Collectors.toList());
	}

	public boolean addCard(Card card) {
		int insert = 0;
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUIdEqualTo(card.getuId()).andNameEqualTo(card.getName()).andCStatusEqualTo(1);
		cardExample.or(new CardExample().createCriteria().andUIdEqualTo(card.getuId()).andIdentityidEqualTo(card.getIdentityID()).andCStatusEqualTo(1));
		if (cardMapper.selectByExample(cardExample).size() == 0) {
			insert = cardMapper.insertSelective(card);
		}
		return insert == 1;
	}


	public boolean deleteCard(int uId, int cId) {
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUIdEqualTo(uId).andCIdEqualTo(cId).andCStatusEqualTo(1);
		List<Card> cards = cardMapper.selectByExample(cardExample);
		if (cards.size() == 0) {
			return false;
		} else {
			Card card = cards.get(0);
			card.setcStatus(0);
			return cardMapper.updateByExample(card, cardExample) == 1;
		}
	}

	public boolean alterCard(CardDTO cardDTO) {
		CardExample cardExample = new CardExample();
		cardExample.createCriteria().andUIdEqualTo(cardDTO.getuId()).andCIdEqualTo(cardDTO.getcId()).andCStatusEqualTo(1);
		List<Card> cards = cardMapper.selectByExample(cardExample);
		if (cards.size() == 0) {
			return false;
		} else {
			Card card = cards.get(0);
			card.setSex(cardDTO.getSex());
			card.setAge(cardDTO.getAge());
			card.setName(cardDTO.getName());
			card.setTelNumber(cardDTO.getTelNumber());
			cardMapper.updateByExample(card, cardExample);
			return true;
		}
	}

	public Integer queryUIdByCId(Integer cId) {
		return cardMapper.selectByPrimaryKey(cId).getuId();
	}
}
