import request from '@/utils/request'

// 查询住户信息列表
export function listResidents(query) {
  return request({
    url: '/community/residents/list',
    method: 'get',
    params: query
  })
}

// 查询住户信息详细
export function getResidents(residentsId) {
  return request({
    url: '/community/residents/' + residentsId,
    method: 'get'
  })
}

// 新增住户信息
export function addResidents(data) {
  return request({
    url: '/community/residents',
    method: 'post',
    data: data
  })
}

// 修改住户信息
export function updateResidents(data) {
  return request({
    url: '/community/residents',
    method: 'put',
    data: data
  })
}

// 删除住户信息
export function delResidents(residentsId) {
  return request({
    url: '/community/residents/' + residentsId,
    method: 'delete'
  })
}
