package io.nebulas.explorer.util;

import io.nebulas.explorer.domain.NebBlock;
import io.nebulas.explorer.domain.NebTransaction;
import io.nebulas.explorer.service.thirdpart.nebulas.bean.Block;
import io.nebulas.explorer.service.thirdpart.nebulas.bean.Transaction;

import java.util.Date;

/**
 * Desc:
 * User: nathan
 * Date: 2018-02-27
 */
public class BlockHelper {

    public static NebBlock buildNebBlock(Block blk, long libBlkHeight) {
        return NebBlock.builder()
                .height(blk.getHeight())
                .hash(blk.getHash())
                .parentHash(blk.getParentHash())
                .timestamp(new Date(blk.getTimestamp() * 1000))
                .miner(blk.getMiner())
                .coinbase(blk.getCoinbase())
                .finality(blk.getHeight() <= libBlkHeight)
                .build();
    }

    public static NebTransaction buildNebTransaction(Transaction tx, Block blk,int seq,String data) {
        return NebTransaction.builder()
                .hash(tx.getHash())
                .blockHeight(blk.getHeight())
                .blockHash(blk.getHash())
                .txSeq(seq)
                .from(tx.getFrom())
                .to(tx.getTo())
                .status(tx.getStatus())
                .value(tx.getValue())
                .nonce(tx.getNonce())
                .timestamp(new Date(tx.getTimestamp() * 1000))
                .type(tx.getType())
                .data(data)
                .gasPrice(tx.getGasPrice())
                .gasLimit(tx.getGasLimit())
                .gasUsed(tx.getGasUsed())
                .createdAt(new Date())
                .build();
    }
}
