import { localAxios } from "@/util/axios";

const local = localAxios();

function getCardData(category, success, fail) {
  local.get(`/flashcard?category=${category}`).then(success).catch(fail);
}

function deleteLike(cardId, success, fail) {
  local.delete(`/flashcard/${cardId}/favorite`).then(success).catch(fail);
}

export { getCardData, deleteLike, postLike, sendCardID };
