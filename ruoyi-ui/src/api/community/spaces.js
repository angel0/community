import request from '@/utils/request'

// 查询车位信息列表
export function listSpaces(query) {
  return request({
    url: '/community/spaces/list',
    method: 'get',
    params: query
  })
}

// 查询车位信息详细
export function getSpaces(parkId) {
  return request({
    url: '/community/spaces/' + parkId,
    method: 'get'
  })
}

// 新增车位信息
export function addSpaces(data) {
  return request({
    url: '/community/spaces',
    method: 'post',
    data: data
  })
}

// 修改车位信息
export function updateSpaces(data) {
  return request({
    url: '/community/spaces',
    method: 'put',
    data: data
  })
}

// 删除车位信息
export function delSpaces(parkId) {
  return request({
    url: '/community/spaces/' + parkId,
    method: 'delete'
  })
}
